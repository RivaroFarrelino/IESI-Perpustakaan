<?php
function read()
{
    $cookie_name = "cart";
    if (!isset($_COOKIE[$cookie_name])) {
        echo "cart kosong";
    } else {
        $cart = json_decode($_COOKIE[$cookie_name], true);
        echo "<table border=1>";
        echo "<tr><td>No</td><td>ID</td><td>Judul</td><td>Action</td></tr>";
        $i=1;
        foreach ($cart as $i => $row) {
            echo "<tr><td>$i</td><td>$row[0]</td><td>$row[1]</td>";
            echo "<td><a href='./pinjam.php?fitur=delete&idbuku=$i'>Hapus</a> | ";
            echo "<a href='./return.php?fitur=return&idbuku={$row[0]}&judul={$row[1]}'>Kembalikan</a></td></tr>";
            $i++;
        }
        
        echo "</table>";
        echo "<a href='../fitur.php'>CARI</a> <br>";
        echo "<a href='pinjam.php?fitur=save'>SIMPAN</a>";
    }
}
?>