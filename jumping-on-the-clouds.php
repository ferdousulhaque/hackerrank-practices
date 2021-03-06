<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the jumpingOnClouds function below.
function jumpingOnClouds($c) {
    $jump = 0;
    for($i=1;$i<count($c)-1;$i++){
        if($c[$i] == $c[$i+1]){
            $i++;
        }
        $jump++;
    }
    return $jump;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $n);

fscanf($stdin, "%[^\n]", $c_temp);

$c = array_map('intval', preg_split('/ /', $c_temp, -1, PREG_SPLIT_NO_EMPTY));

$result = jumpingOnClouds($c);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
