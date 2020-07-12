<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the cutTheSticks function below.
function cutTheSticks($arr) {
    while(count($arr) > 1){
        $min = $arr[0];
        // Find the cut length
        foreach($arr as $a){
            if($a < $min){
                $min = $a;
            }
        }
        
        // After cut the new array
        $newArr = [];
        foreach($arr as $a){
            if($a != $min){
                $newArr[] = ($a - $min);
            }
        }
        $stickCount[] = count($arr);
        $arr = $newArr;
    }
    $stickCount[] = 1;
    
    return $stickCount;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $n);

fscanf($stdin, "%[^\n]", $arr_temp);

$arr = array_map('intval', preg_split('/ /', $arr_temp, -1, PREG_SPLIT_NO_EMPTY));

$result = cutTheSticks($arr);

fwrite($fptr, implode("\n", $result) . "\n");

fclose($stdin);
fclose($fptr);
