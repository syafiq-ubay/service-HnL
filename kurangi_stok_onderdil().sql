-- Buat dulu fungsi yang akan dijalankan oleh trigger
CREATE OR REPLACE FUNCTION kurangi_stok_onderdil()
RETURNS TRIGGER AS $$
BEGIN
  -- Kurangi stok onderdil sesuai dengan jumlah yang digunakan dalam detail service
  UPDATE onderdil
  SET stok = stok - NEW.jmh_onderdil
  WHERE kode_onderdil = NEW.kode_onderdil;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Setelah itu, buat trigger yang akan memanggil fungsi di atas
CREATE TRIGGER tr_kurangi_stok_onderdil
AFTER INSERT ON detail_service
FOR EACH ROW
WHEN (NEW.kode_onderdil IS NOT NULL)
EXECUTE FUNCTION kurangi_stok_onderdil();
