<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the beautifulTriplets function below.
function beautifulTriplets($d, $arr) {
    $triplets = 0;
    for($i=0;$i<count($arr);$i++){
        $heystack = $arr;
        $pin = $heystack[$i];
        unset($heystack[$i]);

        if(in_array($pin+$d,$heystack) && in_array($pin+$d+$d,$heystack)){
            $triplets++;
        }
    }

    return $triplets;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%[^\n]", $nd_temp);
$nd = explode(' ', $nd_temp);

$n = intval($nd[0]);

$d = intval($nd[1]);

fscanf($stdin, "%[^\n]", $arr_temp);

$arr = array_map('intval', preg_split('/ /', $arr_temp, -1, PREG_SPLIT_NO_EMPTY));

$result = beautifulTriplets($d, $arr);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
