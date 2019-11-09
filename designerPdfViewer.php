<?php

// Complete the designerPdfViewer function below.
function designerPdfViewer($h, $word) {
    $letterVal = $max = $j = 0;
    for($j=0;$j<strlen($word);$j++){
        for($i=97;$i<124;$i++){
            if(chr($i) == $word[$j]){
                break;
            }
            $letterVal++;
        }
        if($h[$letterVal] > $max){
            $max = $h[$letterVal];
        }
        $letterVal = 0;
    }
    
    return strlen($word)*$max;

}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%[^\n]", $h_temp);

$h = array_map('intval', preg_split('/ /', $h_temp, -1, PREG_SPLIT_NO_EMPTY));

$word = '';
fscanf($stdin, "%[^\n]", $word);

$result = designerPdfViewer($h, $word);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
