<?php
function returnBook($idbuku, $judul)
{
    $cookie_name = "returned_cart";
    $returnedCart = json_decode($_COOKIE[$cookie_name], true) ?? [];

    $link = mysqli_connect("127.0.0.1", "root", "", "perpustakaan");
    $query = "DELETE FROM dipinjam WHERE buku_id = $idbuku";
    mysqli_query($link, $query);

    $bookReturned = ['idbuku' => $idbuku, 'judul' => $judul, 'tanggal' => date('Y-m-d H:i:s')];
    $returnedCart[] = $bookReturned;

    setcookie($cookie_name, json_encode($returnedCart));

    header('Location: ../fitur.php');
    exit;
}
?>
