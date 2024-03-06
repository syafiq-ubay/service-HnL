PGDMP         -                {            fix service    15.4    15.4 Q    q           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            r           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            s           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            t           1262    19250    fix service    DATABASE     �   CREATE DATABASE "fix service" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';
    DROP DATABASE "fix service";
                postgres    false            �            1255    27784    kurangi_stok_onderdil()    FUNCTION     1  CREATE FUNCTION public.kurangi_stok_onderdil() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  -- Kurangi stok onderdil sesuai dengan jumlah yang digunakan dalam detail service
  UPDATE onderdil
  SET stok = stok - NEW.jmh_service
  WHERE kode_onderdil = NEW.kode_onderdil;

  RETURN NEW;
END;
$$;
 .   DROP FUNCTION public.kurangi_stok_onderdil();
       public          postgres    false            �            1255    27805    tambah_stok_onderdil()    FUNCTION     -  CREATE FUNCTION public.tambah_stok_onderdil() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
$$;
 -   DROP FUNCTION public.tambah_stok_onderdil();
       public          postgres    false            �            1259    36023    admin    TABLE     �   CREATE TABLE public.admin (
    id_admin character(13) NOT NULL,
    nama_admin character varying(150),
    username character varying(100),
    password character varying(50)
);
    DROP TABLE public.admin;
       public         heap    postgres    false            �            1259    19251    barang_customer    TABLE     �   CREATE TABLE public.barang_customer (
    kode_barang character(13) NOT NULL,
    type_barang character varying(10),
    nama_barang character varying(150),
    nama_customer character varying(150),
    telp_customer character(13)
);
 #   DROP TABLE public.barang_customer;
       public         heap    postgres    false            �            1259    19257    detail_service    TABLE     �   CREATE TABLE public.detail_service (
    kode_service character(13) NOT NULL,
    kode_onderdil character(13) NOT NULL,
    jmh_service integer,
    subtotal double precision
);
 "   DROP TABLE public.detail_service;
       public         heap    postgres    false            �            1259    19265    detail_supply    TABLE     �   CREATE TABLE public.detail_supply (
    kode_supply character(13) NOT NULL,
    kode_onderdil character(13) NOT NULL,
    jmh_supply integer,
    subtotal_detailsupply double precision
);
 !   DROP TABLE public.detail_supply;
       public         heap    postgres    false            �            1259    19273    jenis_onderdil    TABLE     �   CREATE TABLE public.jenis_onderdil (
    kode_jenis character(13) NOT NULL,
    type_jenis character varying(200),
    nama_jenis character varying(100)
);
 "   DROP TABLE public.jenis_onderdil;
       public         heap    postgres    false            �            1259    19279    kasir    TABLE     �   CREATE TABLE public.kasir (
    id_kasir character(11) NOT NULL,
    nama_kasir character varying(150),
    telp_kasir character(13),
    email_kasir character varying(200),
    alamat_kasir character varying(200)
);
    DROP TABLE public.kasir;
       public         heap    postgres    false            �            1259    19287    mekanik    TABLE     �   CREATE TABLE public.mekanik (
    id_mekanik character(11) NOT NULL,
    nama_mekanik character varying(150),
    telp_mekanik character(13),
    email_mekanik character varying(200),
    alamat_mekanik character varying(200)
);
    DROP TABLE public.mekanik;
       public         heap    postgres    false            �            1259    19295    onderdil    TABLE     �   CREATE TABLE public.onderdil (
    kode_onderdil character(13) NOT NULL,
    kode_jenis character(13),
    nama_onderdil character varying(150),
    stok integer,
    harga_onderdil double precision,
    id_supplier character(13)
);
    DROP TABLE public.onderdil;
       public         heap    postgres    false            �            1259    19302    pembayaran_service    TABLE       CREATE TABLE public.pembayaran_service (
    id_pembayaranservice character(11) NOT NULL,
    kode_service character(13),
    id_kasir character(11),
    tgl_pembayaranservice date,
    kurang_bayar double precision,
    sudah_bayar double precision,
    status character varying(20)
);
 &   DROP TABLE public.pembayaran_service;
       public         heap    postgres    false            �            1259    19310    pembayaran_supply    TABLE     �   CREATE TABLE public.pembayaran_supply (
    id_pembayaransupply character(11) NOT NULL,
    kode_supply character(13),
    tgl_pembayaransupply date
);
 %   DROP TABLE public.pembayaran_supply;
       public         heap    postgres    false            �            1259    19317    service    TABLE       CREATE TABLE public.service (
    kode_service character(13) NOT NULL,
    id_mekanik character(11),
    kode_barang character(13),
    tgl_service date,
    total_service double precision,
    keterangan character varying(200),
    harga_service double precision
);
    DROP TABLE public.service;
       public         heap    postgres    false            �            1259    19325    supplier    TABLE     �   CREATE TABLE public.supplier (
    id_supplier character(11) NOT NULL,
    nama_supplier character varying(150),
    toko_supplier character varying(100),
    telp_supplier character(13),
    alamat_supplier character varying(200)
);
    DROP TABLE public.supplier;
       public         heap    postgres    false            �            1259    19331    supply    TABLE     �   CREATE TABLE public.supply (
    kode_supply character(13) NOT NULL,
    id_supplier character(11),
    tgl_supply date,
    total_supply double precision,
    status character varying(20)
);
    DROP TABLE public.supply;
       public         heap    postgres    false            n          0    36023    admin 
   TABLE DATA           I   COPY public.admin (id_admin, nama_admin, username, password) FROM stdin;
    public          postgres    false    226   �h       b          0    19251    barang_customer 
   TABLE DATA           n   COPY public.barang_customer (kode_barang, type_barang, nama_barang, nama_customer, telp_customer) FROM stdin;
    public          postgres    false    214   i       c          0    19257    detail_service 
   TABLE DATA           \   COPY public.detail_service (kode_service, kode_onderdil, jmh_service, subtotal) FROM stdin;
    public          postgres    false    215   	j       d          0    19265    detail_supply 
   TABLE DATA           f   COPY public.detail_supply (kode_supply, kode_onderdil, jmh_supply, subtotal_detailsupply) FROM stdin;
    public          postgres    false    216   fj       e          0    19273    jenis_onderdil 
   TABLE DATA           L   COPY public.jenis_onderdil (kode_jenis, type_jenis, nama_jenis) FROM stdin;
    public          postgres    false    217   �j       f          0    19279    kasir 
   TABLE DATA           \   COPY public.kasir (id_kasir, nama_kasir, telp_kasir, email_kasir, alamat_kasir) FROM stdin;
    public          postgres    false    218   pk       g          0    19287    mekanik 
   TABLE DATA           h   COPY public.mekanik (id_mekanik, nama_mekanik, telp_mekanik, email_mekanik, alamat_mekanik) FROM stdin;
    public          postgres    false    219   pl       h          0    19295    onderdil 
   TABLE DATA           o   COPY public.onderdil (kode_onderdil, kode_jenis, nama_onderdil, stok, harga_onderdil, id_supplier) FROM stdin;
    public          postgres    false    220   m       i          0    19302    pembayaran_service 
   TABLE DATA           �   COPY public.pembayaran_service (id_pembayaranservice, kode_service, id_kasir, tgl_pembayaranservice, kurang_bayar, sudah_bayar, status) FROM stdin;
    public          postgres    false    221   �m       j          0    19310    pembayaran_supply 
   TABLE DATA           c   COPY public.pembayaran_supply (id_pembayaransupply, kode_supply, tgl_pembayaransupply) FROM stdin;
    public          postgres    false    222   jn       k          0    19317    service 
   TABLE DATA              COPY public.service (kode_service, id_mekanik, kode_barang, tgl_service, total_service, keterangan, harga_service) FROM stdin;
    public          postgres    false    223   �n       l          0    19325    supplier 
   TABLE DATA           m   COPY public.supplier (id_supplier, nama_supplier, toko_supplier, telp_supplier, alamat_supplier) FROM stdin;
    public          postgres    false    224   >o       m          0    19331    supply 
   TABLE DATA           \   COPY public.supply (kode_supply, id_supplier, tgl_supply, total_supply, status) FROM stdin;
    public          postgres    false    225    p       �           2606    36027    admin admin_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id_admin);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public            postgres    false    226            �           2606    19255 "   barang_customer pk_barang_customer 
   CONSTRAINT     i   ALTER TABLE ONLY public.barang_customer
    ADD CONSTRAINT pk_barang_customer PRIMARY KEY (kode_barang);
 L   ALTER TABLE ONLY public.barang_customer DROP CONSTRAINT pk_barang_customer;
       public            postgres    false    214            �           2606    19261     detail_service pk_detail_service 
   CONSTRAINT     w   ALTER TABLE ONLY public.detail_service
    ADD CONSTRAINT pk_detail_service PRIMARY KEY (kode_service, kode_onderdil);
 J   ALTER TABLE ONLY public.detail_service DROP CONSTRAINT pk_detail_service;
       public            postgres    false    215    215            �           2606    19269    detail_supply pk_detail_supply 
   CONSTRAINT     t   ALTER TABLE ONLY public.detail_supply
    ADD CONSTRAINT pk_detail_supply PRIMARY KEY (kode_supply, kode_onderdil);
 H   ALTER TABLE ONLY public.detail_supply DROP CONSTRAINT pk_detail_supply;
       public            postgres    false    216    216            �           2606    19277     jenis_onderdil pk_jenis_onderdil 
   CONSTRAINT     f   ALTER TABLE ONLY public.jenis_onderdil
    ADD CONSTRAINT pk_jenis_onderdil PRIMARY KEY (kode_jenis);
 J   ALTER TABLE ONLY public.jenis_onderdil DROP CONSTRAINT pk_jenis_onderdil;
       public            postgres    false    217            �           2606    19285    kasir pk_kasir 
   CONSTRAINT     R   ALTER TABLE ONLY public.kasir
    ADD CONSTRAINT pk_kasir PRIMARY KEY (id_kasir);
 8   ALTER TABLE ONLY public.kasir DROP CONSTRAINT pk_kasir;
       public            postgres    false    218            �           2606    19293    mekanik pk_mekanik 
   CONSTRAINT     X   ALTER TABLE ONLY public.mekanik
    ADD CONSTRAINT pk_mekanik PRIMARY KEY (id_mekanik);
 <   ALTER TABLE ONLY public.mekanik DROP CONSTRAINT pk_mekanik;
       public            postgres    false    219            �           2606    19299    onderdil pk_onderdil 
   CONSTRAINT     ]   ALTER TABLE ONLY public.onderdil
    ADD CONSTRAINT pk_onderdil PRIMARY KEY (kode_onderdil);
 >   ALTER TABLE ONLY public.onderdil DROP CONSTRAINT pk_onderdil;
       public            postgres    false    220            �           2606    19306 (   pembayaran_service pk_pembayaran_service 
   CONSTRAINT     x   ALTER TABLE ONLY public.pembayaran_service
    ADD CONSTRAINT pk_pembayaran_service PRIMARY KEY (id_pembayaranservice);
 R   ALTER TABLE ONLY public.pembayaran_service DROP CONSTRAINT pk_pembayaran_service;
       public            postgres    false    221            �           2606    19314 &   pembayaran_supply pk_pembayaran_supply 
   CONSTRAINT     u   ALTER TABLE ONLY public.pembayaran_supply
    ADD CONSTRAINT pk_pembayaran_supply PRIMARY KEY (id_pembayaransupply);
 P   ALTER TABLE ONLY public.pembayaran_supply DROP CONSTRAINT pk_pembayaran_supply;
       public            postgres    false    222            �           2606    19321    service pk_service 
   CONSTRAINT     Z   ALTER TABLE ONLY public.service
    ADD CONSTRAINT pk_service PRIMARY KEY (kode_service);
 <   ALTER TABLE ONLY public.service DROP CONSTRAINT pk_service;
       public            postgres    false    223            �           2606    19329    supplier pk_supplier 
   CONSTRAINT     [   ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT pk_supplier PRIMARY KEY (id_supplier);
 >   ALTER TABLE ONLY public.supplier DROP CONSTRAINT pk_supplier;
       public            postgres    false    224            �           2606    19335    supply pk_supply 
   CONSTRAINT     W   ALTER TABLE ONLY public.supply
    ADD CONSTRAINT pk_supply PRIMARY KEY (kode_supply);
 :   ALTER TABLE ONLY public.supply DROP CONSTRAINT pk_supply;
       public            postgres    false    225            �           1259    19256    barang_customer_pk    INDEX     \   CREATE UNIQUE INDEX barang_customer_pk ON public.barang_customer USING btree (kode_barang);
 &   DROP INDEX public.barang_customer_pk;
       public            postgres    false    214            �           1259    19263    detail_service2_fk    INDEX     V   CREATE INDEX detail_service2_fk ON public.detail_service USING btree (kode_onderdil);
 &   DROP INDEX public.detail_service2_fk;
       public            postgres    false    215            �           1259    19264    detail_service_fk    INDEX     T   CREATE INDEX detail_service_fk ON public.detail_service USING btree (kode_service);
 %   DROP INDEX public.detail_service_fk;
       public            postgres    false    215            �           1259    19262    detail_service_pk    INDEX     j   CREATE UNIQUE INDEX detail_service_pk ON public.detail_service USING btree (kode_service, kode_onderdil);
 %   DROP INDEX public.detail_service_pk;
       public            postgres    false    215    215            �           1259    19272    detail_supply2_fk    INDEX     T   CREATE INDEX detail_supply2_fk ON public.detail_supply USING btree (kode_onderdil);
 %   DROP INDEX public.detail_supply2_fk;
       public            postgres    false    216            �           1259    19271    detail_supply_fk    INDEX     Q   CREATE INDEX detail_supply_fk ON public.detail_supply USING btree (kode_supply);
 $   DROP INDEX public.detail_supply_fk;
       public            postgres    false    216            �           1259    19270    detail_supply_pk    INDEX     g   CREATE UNIQUE INDEX detail_supply_pk ON public.detail_supply USING btree (kode_supply, kode_onderdil);
 $   DROP INDEX public.detail_supply_pk;
       public            postgres    false    216    216            �           1259    19278    jenis_onderdil_pk    INDEX     Y   CREATE UNIQUE INDEX jenis_onderdil_pk ON public.jenis_onderdil USING btree (kode_jenis);
 %   DROP INDEX public.jenis_onderdil_pk;
       public            postgres    false    217            �           1259    19286    kasir_pk    INDEX     E   CREATE UNIQUE INDEX kasir_pk ON public.kasir USING btree (id_kasir);
    DROP INDEX public.kasir_pk;
       public            postgres    false    218            �           1259    19294 
   mekanik_pk    INDEX     K   CREATE UNIQUE INDEX mekanik_pk ON public.mekanik USING btree (id_mekanik);
    DROP INDEX public.mekanik_pk;
       public            postgres    false    219            �           1259    19300    onderdil_pk    INDEX     P   CREATE UNIQUE INDEX onderdil_pk ON public.onderdil USING btree (kode_onderdil);
    DROP INDEX public.onderdil_pk;
       public            postgres    false    220            �           1259    19307    pembayaran_service_pk    INDEX     k   CREATE UNIQUE INDEX pembayaran_service_pk ON public.pembayaran_service USING btree (id_pembayaranservice);
 )   DROP INDEX public.pembayaran_service_pk;
       public            postgres    false    221            �           1259    19315    pembayaran_supply_pk    INDEX     h   CREATE UNIQUE INDEX pembayaran_supply_pk ON public.pembayaran_supply USING btree (id_pembayaransupply);
 (   DROP INDEX public.pembayaran_supply_pk;
       public            postgres    false    222            �           1259    19308    relationship_11_fk    INDEX     Y   CREATE INDEX relationship_11_fk ON public.pembayaran_service USING btree (kode_service);
 &   DROP INDEX public.relationship_11_fk;
       public            postgres    false    221            �           1259    19309    relationship_13_fk    INDEX     U   CREATE INDEX relationship_13_fk ON public.pembayaran_service USING btree (id_kasir);
 &   DROP INDEX public.relationship_13_fk;
       public            postgres    false    221            �           1259    19316    relationship_2_fk    INDEX     V   CREATE INDEX relationship_2_fk ON public.pembayaran_supply USING btree (kode_supply);
 %   DROP INDEX public.relationship_2_fk;
       public            postgres    false    222            �           1259    19337    relationship_3_fk    INDEX     K   CREATE INDEX relationship_3_fk ON public.supply USING btree (id_supplier);
 %   DROP INDEX public.relationship_3_fk;
       public            postgres    false    225            �           1259    19301    relationship_6_fk    INDEX     L   CREATE INDEX relationship_6_fk ON public.onderdil USING btree (kode_jenis);
 %   DROP INDEX public.relationship_6_fk;
       public            postgres    false    220            �           1259    19324    relationship_8_fk    INDEX     K   CREATE INDEX relationship_8_fk ON public.service USING btree (id_mekanik);
 %   DROP INDEX public.relationship_8_fk;
       public            postgres    false    223            �           1259    19322 
   service_pk    INDEX     M   CREATE UNIQUE INDEX service_pk ON public.service USING btree (kode_service);
    DROP INDEX public.service_pk;
       public            postgres    false    223            �           1259    19330    supplier_pk    INDEX     N   CREATE UNIQUE INDEX supplier_pk ON public.supplier USING btree (id_supplier);
    DROP INDEX public.supplier_pk;
       public            postgres    false    224            �           1259    19336 	   supply_pk    INDEX     J   CREATE UNIQUE INDEX supply_pk ON public.supply USING btree (kode_supply);
    DROP INDEX public.supply_pk;
       public            postgres    false    225            �           2620    27785 '   detail_service tr_kurangi_stok_onderdil    TRIGGER     �   CREATE TRIGGER tr_kurangi_stok_onderdil AFTER INSERT ON public.detail_service FOR EACH ROW WHEN ((new.kode_onderdil IS NOT NULL)) EXECUTE FUNCTION public.kurangi_stok_onderdil();
 @   DROP TRIGGER tr_kurangi_stok_onderdil ON public.detail_service;
       public          postgres    false    215    215    227            �           2620    27806    supply tr_tambah_stok_onderdil    TRIGGER     �   CREATE TRIGGER tr_tambah_stok_onderdil AFTER UPDATE ON public.supply FOR EACH ROW WHEN ((new.kode_supply IS NOT NULL)) EXECUTE FUNCTION public.tambah_stok_onderdil();
 7   DROP TRIGGER tr_tambah_stok_onderdil ON public.supply;
       public          postgres    false    225    225    228            �           2606    27720    detail_supply CASCADE_supply    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_supply
    ADD CONSTRAINT "CASCADE_supply" FOREIGN KEY (kode_supply) REFERENCES public.supply(kode_supply) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 H   ALTER TABLE ONLY public.detail_supply DROP CONSTRAINT "CASCADE_supply";
       public          postgres    false    225    216    3265            �           2606    36008 ,   detail_service fk_detail_s_detail_se_service    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_service
    ADD CONSTRAINT fk_detail_s_detail_se_service FOREIGN KEY (kode_service) REFERENCES public.service(kode_service) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 V   ALTER TABLE ONLY public.detail_service DROP CONSTRAINT fk_detail_s_detail_se_service;
       public          postgres    false    223    215    3258            �           2606    36233 ,   detail_supply fk_detail_s_detail_su_onderdil    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_supply
    ADD CONSTRAINT fk_detail_s_detail_su_onderdil FOREIGN KEY (kode_onderdil) REFERENCES public.onderdil(kode_onderdil) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 V   ALTER TABLE ONLY public.detail_supply DROP CONSTRAINT fk_detail_s_detail_su_onderdil;
       public          postgres    false    216    3246    220            �           2606    36238 -   detail_service fk_detail_s_detail_su_onderdil    FK CONSTRAINT     �   ALTER TABLE ONLY public.detail_service
    ADD CONSTRAINT fk_detail_s_detail_su_onderdil FOREIGN KEY (kode_onderdil) REFERENCES public.onderdil(kode_onderdil) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 W   ALTER TABLE ONLY public.detail_service DROP CONSTRAINT fk_detail_s_detail_su_onderdil;
       public          postgres    false    220    3246    215            �           2606    19358 '   onderdil fk_onderdil_relations_jenis_on    FK CONSTRAINT     �   ALTER TABLE ONLY public.onderdil
    ADD CONSTRAINT fk_onderdil_relations_jenis_on FOREIGN KEY (kode_jenis) REFERENCES public.jenis_onderdil(kode_jenis) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Q   ALTER TABLE ONLY public.onderdil DROP CONSTRAINT fk_onderdil_relations_jenis_on;
       public          postgres    false    220    217    3237            �           2606    19368 .   pembayaran_service fk_pembayar_relations_kasir    FK CONSTRAINT     �   ALTER TABLE ONLY public.pembayaran_service
    ADD CONSTRAINT fk_pembayar_relations_kasir FOREIGN KEY (id_kasir) REFERENCES public.kasir(id_kasir) ON UPDATE RESTRICT ON DELETE RESTRICT;
 X   ALTER TABLE ONLY public.pembayaran_service DROP CONSTRAINT fk_pembayar_relations_kasir;
       public          postgres    false    221    218    3240            �           2606    36018 0   pembayaran_service fk_pembayar_relations_service    FK CONSTRAINT     �   ALTER TABLE ONLY public.pembayaran_service
    ADD CONSTRAINT fk_pembayar_relations_service FOREIGN KEY (kode_service) REFERENCES public.service(kode_service) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 Z   ALTER TABLE ONLY public.pembayaran_service DROP CONSTRAINT fk_pembayar_relations_service;
       public          postgres    false    3258    221    223            �           2606    35996 .   pembayaran_supply fk_pembayar_relations_supply    FK CONSTRAINT     �   ALTER TABLE ONLY public.pembayaran_supply
    ADD CONSTRAINT fk_pembayar_relations_supply FOREIGN KEY (kode_supply) REFERENCES public.supply(kode_supply) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 X   ALTER TABLE ONLY public.pembayaran_supply DROP CONSTRAINT fk_pembayar_relations_supply;
       public          postgres    false    3265    222    225            �           2606    35991 ,   service fk_service_relations_barang_customer    FK CONSTRAINT     �   ALTER TABLE ONLY public.service
    ADD CONSTRAINT fk_service_relations_barang_customer FOREIGN KEY (kode_barang) REFERENCES public.barang_customer(kode_barang) NOT VALID;
 V   ALTER TABLE ONLY public.service DROP CONSTRAINT fk_service_relations_barang_customer;
       public          postgres    false    214    3224    223            �           2606    19383 $   service fk_service_relations_mekanik    FK CONSTRAINT     �   ALTER TABLE ONLY public.service
    ADD CONSTRAINT fk_service_relations_mekanik FOREIGN KEY (id_mekanik) REFERENCES public.mekanik(id_mekanik) ON UPDATE RESTRICT ON DELETE RESTRICT;
 N   ALTER TABLE ONLY public.service DROP CONSTRAINT fk_service_relations_mekanik;
       public          postgres    false    3243    223    219            �           2606    19388 #   supply fk_supply_relations_supplier    FK CONSTRAINT     �   ALTER TABLE ONLY public.supply
    ADD CONSTRAINT fk_supply_relations_supplier FOREIGN KEY (id_supplier) REFERENCES public.supplier(id_supplier) ON UPDATE RESTRICT ON DELETE RESTRICT;
 M   ALTER TABLE ONLY public.supply DROP CONSTRAINT fk_supply_relations_supplier;
       public          postgres    false    3262    224    225            �           2606    19528 "   onderdil onderdil_id_supplier_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.onderdil
    ADD CONSTRAINT onderdil_id_supplier_fkey FOREIGN KEY (id_supplier) REFERENCES public.supplier(id_supplier) NOT VALID;
 L   ALTER TABLE ONLY public.onderdil DROP CONSTRAINT onderdil_id_supplier_fkey;
       public          postgres    false    3262    224    220            n   N   x�st���342T ���Ĵ�B�Ф�̜̔���b����E��a��e�E"Pur������e�y������W� N�      b   �   x�e��N�0E��W��8N�t۲Ȣ�(aQ!6S�(C�n�*���<Ի��{tf�=�y��;�E���;�v���Z����YO�;A�Gt���,o*Y��*O�l��◵�y�3������6 ��@�h$��u%˄(Dy�7*mì_���$d�?� ���ZL^�ZVͪ����[������ܡC;{��3���D�妲E)�V�H�.�	����`�q��Y*��*d/wY�}.�c�      c   M   x�3424500T N#cCCϐ(\�PEF(����PU#T��2�4�@UeB��&X�2䴄(����� �a!      d   Y   x�}̱�@C�ڙ�	��\������@�h"$�}��CM�����\��,�3'��Mt/ʪ��@�O���z�������W�N&�*"7)'      e   �   x���34400T N�ļ�����TNg./��T�'��$���;17�(*g�&�Z���X��5A�r�J��J��d�!�4CWPZ���5�p-��,0��S��Җ�N�%@ݙyCT�Q%1* ��*�R`�=... Z7\�      f   �   x�U��N�0���S�����N�t��ȅ��f��!�Ѻٷw@I�&MN�L�3Ӻ�2I$�4W�!td�-L�DR�(d����JݍI>���1T�:@|�M���nd��_Iwh�1��w���*T~���X����:x��i��W�4�B�t��Hs���Q��-���/���n��&��ö���λѱ��D����&nX�V�R�*/�:�Vo��l���!����j�      g   �   x�M���0C��+���VU���L]Xʕ^E�N!<Y�����u"���1��jי���w�u����vb���dV_�&L0n�X�9�A,��뜵���OL	��0��ur`mӂ�%�@������e�q7D>�U�*��xH7�      h   �   x�}�M�0F��)��~���ʠ1�1�M�!!"��B�X�2香�7�/N��Ę��`�1�cA#ʦ{f��b�@7����z����d��S�5�^"��d�z�����A]�U~����8͆�t�g������{���>K�?�GQ��{��k���3c؊V�|�@A��gm�6|!J���� ��KAYu���c\��Kq[9����h�      i   [   x�34200T �` ����F����r�(� � �	F(&�L0�b��X���	�(&� ����V�	1z\\\ �O#�      j   9   x�64200T N ���Q�4202�54�54�
 +2BVd�C�1�"cE1z\\\ �w�      k   {   x�3424500T N_oCC�)����u�tM9����3=1�$S���"�5��$#�IFXM24@6*;�2)?�(��@clN�a���I�%E�覙�p�)���|��bb� ��@?      l   �   x�5�1O�0���o��M� ��VE�^Y.��8�mpc!��8A����N�	Q���s��5�!&ulAϣ�S4�XYQU��z���5C�tԾ���~ɮՑ˅\/�ԏ��W�<��B47���@'��	�⟜����s��w�}*H&T�!�Ҩ�8��_�/���SOMT�]�5�ߘՌn7�bbVOzF���)�{�hs��?p��M      m   N   x�6424500T �� CC#0����X��H�Д��� 8}J����!Z��Z������b�b�W�����=... i�k     