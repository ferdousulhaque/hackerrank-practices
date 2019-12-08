<?php

/*
 * Complete the twoStacks function below.
 */
function twoStacks($x, $a, $b) {
    if($a[0] > $x){
        return 0;
    }
    $sum = 0;
    $from_stack = 1;
    $i = $j = 0;
    $size_a = count($a);
    $size_b = count($b);
    $times = 0;
    while($sum < $x){
        if($from_stack == 1 && $i < $size_a){
            $sum += $a[$i];
            unset($a[$i]);  
            $i++;
            $from_stack = 2;
        }else if($from_stack == 2 && $j < $size_b){
            $sum += $b[$j];
            unset($b[$j]);
            $j++;
            $from_stack = 1;
        }
        print_r($sum);echo "\n";
        $times++;
    }
    print_r($times-1);die;
    return $times;
}

//$fptr = fopen(getenv("OUTPUT_PATH"), "w");
$fptr = fopen("/home/ferdous/hackerrank/in.out", "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $g);

for ($g_itr = 0; $g_itr < $g; $g_itr++) {
    fscanf($stdin, "%[^\n]", $nmx_temp);
    $nmx = explode(' ', $nmx_temp);

    $n = intval($nmx[0]);

    $m = intval($nmx[1]);

    $x = intval($nmx[2]);

    fscanf($stdin, "%[^\n]", $a_temp);

    $a = array_map('intval', preg_split('/ /', $a_temp, -1, PREG_SPLIT_NO_EMPTY));

    fscanf($stdin, "%[^\n]", $b_temp);

    $b = array_map('intval', preg_split('/ /', $b_temp, -1, PREG_SPLIT_NO_EMPTY));

    $result = twoStacks($x, $a, $b);

    fwrite($fptr, $result . "\n");
}

fclose($stdin);
fclose($fptr);
