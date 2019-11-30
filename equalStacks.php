<?php

/*
 * Complete the equalStacks function below.
 */
function equalStacks($h1, $h2, $h3) {
    $iterate = count($h1);
    $totalHeight = 0;
    $st1 = [];
    for($i = $iterate-1; $i >= 0; $i--){
        $totalHeight += $h1[$i];
        array_push($st1,$totalHeight);
    }
    $iterate = count($h2);
    $totalHeight = 0;
    $st2 = [];
    for($i = $iterate-1; $i >= 0; $i--){
        $totalHeight += $h2[$i];
        array_push($st2,$totalHeight);
    }
    $iterate = count($h3);
    $totalHeight = 0;
    $st3 = [];
    for($i = $iterate-1; $i >= 0; $i--){
        $totalHeight += $h3[$i];
        array_push($st3,$totalHeight);
    }

    while(1){
        if(empty($st1) || empty($st2) || empty($st3)){
            return 0;
        }else{
            $st1Total = $st1[count($st1)-1];
            $st2Total = $st2[count($st2)-1];
            $st3Total = $st3[count($st3)-1];

            if(($st1Total == $st2Total) && ($st1Total  == $st3Total)){
                return $st1Total;
            }

            if(($st1Total >= $st2Total) && ($st1Total >= $st3Total)){
                array_pop($st1);
            }
            else if(($st2Total >= $st1Total) && ($st2Total >= $st3Total)){
                array_pop($st2);
            }
            else if(($st3Total >= $st1Total) && ($st3Total >= $st2Total)){
                array_pop($st3);
            }
        }
    }
}

//$fptr = fopen(getenv("OUTPUT_PATH"), "w");
$fptr = fopen("/home/ferdous/java/in.out", "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%[^\n]", $n1N2N3_temp);
$n1N2N3 = explode(' ', $n1N2N3_temp);

$n1 = intval($n1N2N3[0]);

$n2 = intval($n1N2N3[1]);

$n3 = intval($n1N2N3[2]);

fscanf($stdin, "%[^\n]", $h1_temp);

$h1 = array_map('intval', preg_split('/ /', $h1_temp, -1, PREG_SPLIT_NO_EMPTY));

fscanf($stdin, "%[^\n]", $h2_temp);

$h2 = array_map('intval', preg_split('/ /', $h2_temp, -1, PREG_SPLIT_NO_EMPTY));

fscanf($stdin, "%[^\n]", $h3_temp);

$h3 = array_map('intval', preg_split('/ /', $h3_temp, -1, PREG_SPLIT_NO_EMPTY));

$result = equalStacks($h1, $h2, $h3);
print_r($result);die;
fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
