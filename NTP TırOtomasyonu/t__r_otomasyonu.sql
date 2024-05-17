-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 16 May 2024, 15:24:33
-- Sunucu sürümü: 10.4.25-MariaDB
-- PHP Sürümü: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `tır_otomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `araçlar`
--

CREATE TABLE `araçlar` (
  `araçID` int(11) NOT NULL,
  `plaka` varchar(11) COLLATE utf8mb4_turkish_ci NOT NULL,
  `marka` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yıl` int(11) NOT NULL,
  `araç_tipi` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `durum` enum('aktif','inaktif') COLLATE utf8mb4_turkish_ci NOT NULL,
  `km` int(11) NOT NULL,
  `bakımı` enum('var','yok') COLLATE utf8mb4_turkish_ci NOT NULL,
  `yakıt_türü` varchar(10) COLLATE utf8mb4_turkish_ci NOT NULL,
  `şoförID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `araçlar`
--

INSERT INTO `araçlar` (`araçID`, `plaka`, `marka`, `yıl`, `araç_tipi`, `durum`, `km`, `bakımı`, `yakıt_türü`, `şoförID`) VALUES
(3, '16 İSTE 31', 'SCANİA', 2022, 'Tır', 'aktif', 116025, 'var', 'Dizel', 1),
(5, '46 İSTE 31', 'SCANİA', 2022, 'Tır', 'aktif', 325235, 'var', 'Dizel', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanıcılar`
--

CREATE TABLE `kullanıcılar` (
  `kullanıcıID` int(11) NOT NULL,
  `kullanıcı_adı` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `şifre` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `ad` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `soyad` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `eposta` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `tel_no` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `rolü` enum('kullanıcı','admin') COLLATE utf8mb4_turkish_ci DEFAULT 'kullanıcı',
  `kayıt_tarihi` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kullanıcılar`
--

INSERT INTO `kullanıcılar` (`kullanıcıID`, `kullanıcı_adı`, `şifre`, `ad`, `soyad`, `eposta`, `tel_no`, `rolü`, `kayıt_tarihi`) VALUES
(1, 'admin', 'admin123', 'egemen', 'der', 'egemender@eposta.com', '5508002000', 'admin', '2024-05-13 12:28:34'),
(8, 'normal kullanıcı', 'normal', 'emre', 'yusuf', 'emre@posta.com', '5508002002', 'kullanıcı', '2024-05-14 15:30:28');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `müşteriler`
--

CREATE TABLE `müşteriler` (
  `müşteriID` int(11) NOT NULL,
  `ad` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `soyad` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `tel_no` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `email` varchar(35) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kayıt_tarihi` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `müşteriler`
--

INSERT INTO `müşteriler` (`müşteriID`, `ad`, `soyad`, `tel_no`, `email`, `kayıt_tarihi`) VALUES
(1, 'Arda', 'Isırmaz', '5508002222', 'ArdaIsırmaz@email.com', '2024-05-15 12:56:42');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `odemeler`
--

CREATE TABLE `odemeler` (
  `odeme_id` int(11) NOT NULL,
  `ödeme_tarihi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `satış_id` int(11) NOT NULL,
  `ürün_id` int(11) NOT NULL,
  `müşteri_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `odemeler`
--

INSERT INTO `odemeler` (`odeme_id`, `ödeme_tarihi`, `satış_id`, `ürün_id`, `müşteri_id`) VALUES
(1, '2024-05-16 13:16:11', 1, 1, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satislar`
--

CREATE TABLE `satislar` (
  `satışID` int(11) NOT NULL,
  `ürünID` int(11) DEFAULT NULL,
  `müşteriID` int(11) DEFAULT NULL,
  `araçID` int(11) DEFAULT NULL,
  `şoförID` int(11) DEFAULT NULL,
  `miktar` decimal(10,2) DEFAULT NULL,
  `toplam_fiyat` decimal(10,2) DEFAULT NULL,
  `satış_tarihi` timestamp NOT NULL DEFAULT current_timestamp(),
  `ödeme_durumu` enum('Ödendi','Ödenmedi') COLLATE utf8mb4_turkish_ci DEFAULT 'Ödenmedi'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `satislar`
--

INSERT INTO `satislar` (`satışID`, `ürünID`, `müşteriID`, `araçID`, `şoförID`, `miktar`, `toplam_fiyat`, `satış_tarihi`, `ödeme_durumu`) VALUES
(1, 1, 1, 3, 2, '100.00', '500.00', '2024-05-16 01:33:51', 'Ödendi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ürünler`
--

CREATE TABLE `ürünler` (
  `ürünID` int(11) NOT NULL,
  `ürün_adı` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kilobaşı_fiyat` decimal(10,2) NOT NULL,
  `toplam_kg` decimal(10,2) NOT NULL,
  `ürün_durumu` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kayıt_tarihi` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `ürünler`
--

INSERT INTO `ürünler` (`ürünID`, `ürün_adı`, `kilobaşı_fiyat`, `toplam_kg`, `ürün_durumu`, `kayıt_tarihi`) VALUES
(1, 'Kum', '5.00', '100.00', 'iyi kalite', '2024-05-15 14:17:23');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `şoförler`
--

CREATE TABLE `şoförler` (
  `şoförID` int(11) NOT NULL,
  `ad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `soyad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `tel_no` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `kayıt_tarihi` timestamp NOT NULL DEFAULT current_timestamp(),
  `durumu` enum('aktif','inaktif') COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `şoförler`
--

INSERT INTO `şoförler` (`şoförID`, `ad`, `soyad`, `tel_no`, `kayıt_tarihi`, `durumu`) VALUES
(1, 'Hiç Kimse', 'Hiç Kimse', '0000000000', '2024-05-14 19:43:22', 'inaktif'),
(2, 'Ekrem', 'İmaro', '5555555555', '2024-05-15 23:15:47', 'inaktif'),
(3, 'Ekrem', 'Dertli', '5558888888', '2024-05-15 23:18:13', 'inaktif');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `araçlar`
--
ALTER TABLE `araçlar`
  ADD PRIMARY KEY (`araçID`),
  ADD KEY `FOREIGN KEY` (`şoförID`);

--
-- Tablo için indeksler `kullanıcılar`
--
ALTER TABLE `kullanıcılar`
  ADD PRIMARY KEY (`kullanıcıID`),
  ADD UNIQUE KEY `kullanıcı_Adı` (`kullanıcı_adı`),
  ADD UNIQUE KEY `eposta` (`eposta`);

--
-- Tablo için indeksler `müşteriler`
--
ALTER TABLE `müşteriler`
  ADD PRIMARY KEY (`müşteriID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Tablo için indeksler `odemeler`
--
ALTER TABLE `odemeler`
  ADD PRIMARY KEY (`odeme_id`),
  ADD KEY `satış_id` (`satış_id`,`ürün_id`,`müşteri_id`),
  ADD KEY `ürün_id` (`ürün_id`),
  ADD KEY `müşteri_id` (`müşteri_id`);

--
-- Tablo için indeksler `satislar`
--
ALTER TABLE `satislar`
  ADD PRIMARY KEY (`satışID`),
  ADD KEY `ürünID` (`ürünID`),
  ADD KEY `müşteriID` (`müşteriID`),
  ADD KEY `araçID` (`araçID`),
  ADD KEY `şoförID` (`şoförID`);

--
-- Tablo için indeksler `ürünler`
--
ALTER TABLE `ürünler`
  ADD PRIMARY KEY (`ürünID`);

--
-- Tablo için indeksler `şoförler`
--
ALTER TABLE `şoförler`
  ADD PRIMARY KEY (`şoförID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `araçlar`
--
ALTER TABLE `araçlar`
  MODIFY `araçID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `kullanıcılar`
--
ALTER TABLE `kullanıcılar`
  MODIFY `kullanıcıID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `müşteriler`
--
ALTER TABLE `müşteriler`
  MODIFY `müşteriID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `odemeler`
--
ALTER TABLE `odemeler`
  MODIFY `odeme_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `satislar`
--
ALTER TABLE `satislar`
  MODIFY `satışID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `ürünler`
--
ALTER TABLE `ürünler`
  MODIFY `ürünID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `şoförler`
--
ALTER TABLE `şoförler`
  MODIFY `şoförID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `araçlar`
--
ALTER TABLE `araçlar`
  ADD CONSTRAINT `araçlar_ibfk_1` FOREIGN KEY (`şoförID`) REFERENCES `şoförler` (`şoförID`);

--
-- Tablo kısıtlamaları `odemeler`
--
ALTER TABLE `odemeler`
  ADD CONSTRAINT `odemeler_ibfk_1` FOREIGN KEY (`satış_id`) REFERENCES `satislar` (`satışID`),
  ADD CONSTRAINT `odemeler_ibfk_2` FOREIGN KEY (`ürün_id`) REFERENCES `ürünler` (`ürünID`),
  ADD CONSTRAINT `odemeler_ibfk_3` FOREIGN KEY (`müşteri_id`) REFERENCES `müşteriler` (`müşteriID`);

--
-- Tablo kısıtlamaları `satislar`
--
ALTER TABLE `satislar`
  ADD CONSTRAINT `satislar_ibfk_1` FOREIGN KEY (`ürünID`) REFERENCES `ürünler` (`ürünID`),
  ADD CONSTRAINT `satislar_ibfk_2` FOREIGN KEY (`müşteriID`) REFERENCES `müşteriler` (`müşteriID`),
  ADD CONSTRAINT `satislar_ibfk_3` FOREIGN KEY (`araçID`) REFERENCES `araçlar` (`araçID`),
  ADD CONSTRAINT `satislar_ibfk_4` FOREIGN KEY (`şoförID`) REFERENCES `şoförler` (`şoförID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
