<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the appendAndDelete function below.
function appendAndDelete($s, $t, $k) {
    $com = 0;
    $len = strlen($t)>strlen($s)?strlen($s):strlen($t);
    for ($i=0; $i<$len;$i++){
        if($s[$i] == $t[$i]){
            $com++;
        }else
            break;
    }
    
    //CASE A
    if((strlen($s)+strlen($t)-2*$com)>$k){
        return "Yes";
    }
    //CASE B
    else if((strlen($s)+strlen($t)-2*$com)%2==$k%2){
        return "Yes";
    }
    //CASE C
    else if((strlen($s)+strlen($t)-$k)<0){
        return "Yes";
    }
    //CASE D
    else{
        return "No";
    }
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

$s = '';
fscanf($stdin, "%[^\n]", $s);

$t = '';
fscanf($stdin, "%[^\n]", $t);

fscanf($stdin, "%d\n", $k);

$result = appendAndDelete($s, $t, $k);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
