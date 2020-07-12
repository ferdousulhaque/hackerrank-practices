<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the minimumDistances function below.
function minimumDistances($a) {
    foreach($a as $k => $v){
        $p[$v][] = $k;
    }
    foreach($p as $s){
        if(count($s) == 2){
            $d[] = abs($s[0] - $s[1]);
        }
    }
    if(empty($d)) return -1;
    else if(count($d) == 1) return $d[0];
    else{
        return getMin($d);
    }
}

function getMin($a){
    $min = $a[0];
    for($i=0;$i<count($a);$i++){
        if($a[$i] < $min){
            $min = $a[$i];
        }
    }
    return $min;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $n);

fscanf($stdin, "%[^\n]", $a_temp);

$a = array_map('intval', preg_split('/ /', $a_temp, -1, PREG_SPLIT_NO_EMPTY));

$result = minimumDistances($a);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
