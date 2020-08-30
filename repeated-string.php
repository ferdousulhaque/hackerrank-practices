<?php
putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the repeatedString function below.
function repeatedString($s, $n) {
    $getACount = count_chars($s, 1)['97'];
    $div = intval($n/strlen($s));
    
    if($n % strlen($s) == 0){
        $totalACount = $div * $getACount;
    }else{
        $extra = $n % strlen($s);
        $totalACount = $getACount * $div;
        for($i=0;$i<$extra;$i++){
            if($s[$i] == 'a'){
                $totalACount++;
            }
        }
    }
    return $totalACount;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

$s = '';
fscanf($stdin, "%[^\n]", $s);

fscanf($stdin, "%ld\n", $n);

$result = repeatedString($s, $n);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
