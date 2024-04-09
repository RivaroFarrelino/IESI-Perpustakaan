<?php
include "delete-cart.php";
include "return-cart.php";

$fitur = $_GET['fitur'];
switch ($fitur) {
    case 'return':
        $idbuku = $_GET['idbuku'];
        $judul = $_GET['judul'];
        returnBook($idbuku, $judul);
        header('location:return.php?fitur=read');
        break;
    case 'read':
    default:
        readReturnedBooks();
        break;
}

function readReturnedBooks()
{
    $cookie_name = "returned_cart";
    if (!isset($_COOKIE[$cookie_name])) {
        echo "Tidak ada buku yang dikembalikan.";
    } else {
        $returnedCart = json_decode($_COOKIE[$cookie_name], true);
        echo "<h2>Buku yang Telah Dikembalikan</h2>";
        echo "<table border='1'>";
        echo "<tr><th>ID</th><th>Judul Buku</th><th>Tanggal Pengembalian</th></tr>";
        foreach ($returnedCart as $book) {
            echo "<tr><td>{$book['idbuku']}</td><td>{$book['judul']}</td><td>{$book['tanggal']}</td></tr>";
        }
        echo "</table>";
    }
}

?>
