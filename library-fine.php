<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the libraryFine function below.
function libraryFine($d1, $m1, $y1, $d2, $m2, $y2) {
    if($y1 < $y2 || $y1 == $y2){
        if($m1 == $m2 || $m1 < $m2){
            if($d1 == $d2 || $d1 < $d2){
                return 0;
            }else {
                return ($d1-$d2)*15;
            }
        }else {
            return ($m1-$m2)*500;
        }
    }else {
        return 1000;
    } 
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%[^\n]", $d1M1Y1_temp);
$d1M1Y1 = explode(' ', $d1M1Y1_temp);

$d1 = intval($d1M1Y1[0]);

$m1 = intval($d1M1Y1[1]);

$y1 = intval($d1M1Y1[2]);

fscanf($stdin, "%[^\n]", $d2M2Y2_temp);
$d2M2Y2 = explode(' ', $d2M2Y2_temp);

$d2 = intval($d2M2Y2[0]);

$m2 = intval($d2M2Y2[1]);

$y2 = intval($d2M2Y2[2]);

$result = libraryFine($d1, $m1, $y1, $d2, $m2, $y2);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
