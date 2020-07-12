<?php

putenv("OUTPUT_PATH=".realpath ('.').'/in.out');

// Complete the timeInWords function below.
function timeInWords($h, $m) {
    $intMinutes = intval($m);
    $digitToText = [
        1 => 'one',
        2 => 'two',
        3 => 'three',
        4 => 'four',
        5 => 'five',
        6 => 'six',
        7 => 'seven',
        8 => 'eight',
        9 => 'nine',
        10 => 'ten',
        11 => 'eleven',
        12 => 'twelve',
        13 => 'thirteen',
        14 => 'fourteen',
        15 => 'quarter',
        16 => 'sixteen',
        17 => 'seventeen',
        18 => 'eighteen',
        19 => 'nineteen',
        20 => 'twenty',
        21 => 'twenty one',
        22 => 'twenty two',
        23 => 'twenty three',
        24 => 'twenty four',
        25 => 'twenty five',
        26 => 'twenty six',
        27 => 'twenty seven',
        28 => 'twenty eight',
        29 => 'twenty nine',
        30 => 'half',
        31 => 'thirty one',
        32 => 'thirty two',
        33 => 'thirty three',
        34 => 'thirty four',
        35 => 'thirty five',
        36 => 'thirty six',
        37 => 'thirty seven',
        38 => 'thirty eight',
        39 => 'thirty nine',
        40 => 'fourty',
        41 => 'fourty one',
        42 => 'fourty two',
        43 => 'fourty three',
        44 => 'fourty four',
        45 => 'quarter',
        46 => 'fourty six',
        47 => 'fourty seven',
        48 => 'fourty eight',
        49 => 'fourty nine',
        50 => 'fifty',
        51 => 'fifty one',
        52 => 'fifty two',
        53 => 'fifty three',
        54 => 'fifty four',
        55 => 'fifty five',
        56 => 'fifty six',
        57 => 'fifty seven',
        58 => 'fifty eight',
        59 => 'fifty nine',
    ];

    $exception = [15,30,45];

    if($intMinutes === 0)
    {
        return $digitToText[$h].' o\' clock';
    }else if($intMinutes >= 1 && $intMinutes <=30)
    {
        $minText = '';
        if(!in_array($intMinutes,$exception)){
            $minText = ($intMinutes==1)?' minute':' minutes';
        }
        
        return $digitToText[$intMinutes]
            .$minText.' past '.$digitToText[$h];
    }else
    {
        $h++;
        $remain = 60 - $intMinutes;
        $minText = !in_array($intMinutes,$exception)?' minutes':'';
        
        return $digitToText[$remain]
            .$minText.' to '.$digitToText[$h];
    }

}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%d\n", $h);

fscanf($stdin, "%d\n", $m);

$result = timeInWords($h, $m);

fwrite($fptr, $result . "\n");

fclose($stdin);
fclose($fptr);
