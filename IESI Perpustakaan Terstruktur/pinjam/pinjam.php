<?php
include "read-cart.php";
include "add-cart.php";
include "delete-cart.php";
include "save-cart.php";
include "return-cart.php";

$fitur = $_GET['fitur'];
switch ($fitur) {
    case 'add':
        $idbuku = $_GET['idbuku'];
        $judul = $_GET['judul'];
        add($idbuku,$judul);
        header('location:pinjam.php?fitur=read');
        break;
    case 'delete':
        $idbuku = $_GET['idbuku'];
        delete($idbuku);
        header('location:pinjam.php?fitur=read');
        break;
    case 'save':
        save();
        header('location:pinjam.php?fitur=read');
        break;
    case 'read':
        default:
            read();
            break;
    case 'pengembalian':
        echo "<a href='./return.php?fitur=return&idbuku=$row[0]&judul=$row[1]'>kembalikan</a>";        
}

?>