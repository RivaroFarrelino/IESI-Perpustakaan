<html>
    <body>
<?php
include "cari.php";
$fitur = $_GET['fitur'] ?? null;
switch ($fitur) {
    case 'pinjam':
        header('location:pinjam/pinjam.php?fitur=read');
        exit;
    case 'cari':
    default:
        $keyword = $_GET['keyword'] ?? null;
        $listbuku = cari($keyword);
        display($listbuku);
        break;
    case 'pengembalian':
        header('location:pinjam/return.php?fitur=read');
        exit;    
}
?>
    </body>
</html>