<?php
function returnBook($idbuku, $judul)
{
    $cookie_name = "returned_cart";
    $returnedCart = json_decode($_COOKIE[$cookie_name], true) ?? [];

    $bookReturned = ['idbuku' => $idbuku, 'judul' => $judul, 'tanggal' => date('Y-m-d H:i:s')];
    $returnedCart[] = $bookReturned;

    setcookie($cookie_name, json_encode($returnedCart));
}
?>
