// Need to find a pair in array for a sum

// Sample Inputs
// var input = [1, 2, 4, 5];
var input = [-4, 1, 9, 11, 15, 50, 74, 110];
// var input = [1, 4, 2, 3];
// var input = [1, 4, 9, 11];
// var input = [1, 4, 9, 1, 1, 5, 7, 0];
var sum = 7;

// Naive Solution
function solution01(arr){
    for(let i=0;i<arr.length;i++){
        let first = arr[i];
        for(let j=i+1;j<arr.length;j++){
            if(first+arr[j] == sum){
                return 'Found';
            }
        }
    }
    return 'Not Found';
}

// Time Complexity O(a*b)
// Space Complexity O(n)

// For sorted array
function solution02(){
    while(input.length > 2){
        let result, first, last = 0;
        first = input[0];
        last = input[input.length-1];
        result = first + last;
        if(result === sum){
            return 'Found';
        }else{
            if(first > sum)
                input.shift();
            if(last > sum)
                input.pop();
        }
    }
    return 'Not Found';
}

// Faster Solution
function solution03(input){
    let complimentarySet = new Set();
    let result = 'Not Found';
    input.forEach(x => {
        if(!complimentarySet.has(x)){
           complimentarySet.add(sum-x); 
        }else{
            result = 'Found'
        }
    });
    return result;
}

// Time Complexity O(n)
// Space Complexity O(a+b)

console.log(solution01(input));
console.log(solution02(input));
console.log(solution03(input));