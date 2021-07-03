<?php

putenv("OUTPUT_PATH=" . realpath('.') . '/in.out');

// Complete the cavityMap function below.
function cavityMap($grid)
{
    $l = intval((count($grid)+1)/2)-1;
    if($l>0){
        for ($j = 0; $j < $l; $j++) {
            for($i = 0; $i < $l; $i++){
                if($grid[$i][$i+1+ $j] < $grid[$i + 1][$i + 1+ $j] &&
                    $grid[$i+1][$i+ $j] < $grid[$i + 1][$i + 1+ $j] &&
                    $grid[$i + 1][$i + 2+ $j] < $grid[$i + 1][$i + 1+ $j] &&
                    $grid[$i + 2][$i + 1+ $j] < $grid[$i + 1][$i + 1+ $j]){
                        
                        $grid[$i + 1][$i + 1] = 'X';
                }
            }
        }
    }
    print_r($grid);die;
    return $grid;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $n);

$grid = array();

for ($i = 0; $i < $n; $i++) {
    $grid_item = '';
    fscanf($stdin, "%[^\n]", $grid_item);
    $grid[] = $grid_item;
}

$result = cavityMap($grid);

fwrite($fptr, implode("\n", $result) . "\n");

fclose($stdin);
fclose($fptr);
