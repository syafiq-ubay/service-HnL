-- Buat dulu fungsi yang akan dijalankan oleh trigger
CREATE OR REPLACE FUNCTION tambah_stok_onderdil()
RETURNS TRIGGER AS $$
BEGIN
  -- Tambahkan stok onderdil sesuai dengan jumlah yang disupply
  UPDATE onderdil
  SET stok = onderdil.stok + (
    SELECT jmh_supply
    FROM detail_supply
    WHERE detail_supply.kode_onderdil = onderdil.kode_onderdil
      AND detail_supply.kode_supply = NEW.kode_supply
    LIMIT 1
  )
  WHERE onderdil.kode_onderdil IN (
    SELECT kode_onderdil
    FROM detail_supply
    WHERE detail_supply.kode_supply = NEW.kode_supply
  );

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Setelah itu, buat trigger yang akan memanggil fungsi di atas
CREATE TRIGGER tr_tambah_stok_onderdil
AFTER UPDATE ON supply
FOR EACH ROW
WHEN (NEW.kode_supply IS NOT NULL)
EXECUTE FUNCTION tambah_stok_onderdil();
