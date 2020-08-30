<?php

putenv("OUTPUT_PATH=" . realpath('.') . '/in.out');

// Complete the serviceLane function below.
function serviceLane($n, $cases, $width)
{
    $result = [];
    foreach ($cases as $case) {
        $testCase = $width;
        $testCase = array_slice($width, $case[0], ($case[1]-$case[0])+1);
        $result[]=min($testCase);
    }
    return $result;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$stdin = fopen("php://stdin", "r");

fscanf($stdin, "%[^\n]", $nt_temp);
$nt = explode(' ', $nt_temp);

$n = intval($nt[0]);

$t = intval($nt[1]);

fscanf($stdin, "%[^\n]", $width_temp);

$width = array_map('intval', preg_split('/ /', $width_temp, -1, PREG_SPLIT_NO_EMPTY));

$cases = array();

for ($i = 0; $i < $t; $i++) {
    fscanf($stdin, "%[^\n]", $cases_temp);
    $cases[] = array_map('intval', preg_split('/ /', $cases_temp, -1, PREG_SPLIT_NO_EMPTY));
}

$result = serviceLane($n, $cases, $width);

fwrite($fptr, implode("\n", $result) . "\n");

fclose($stdin);
fclose($fptr);
