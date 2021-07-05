
var str = "This is a simple test"

function sol01(str) {
    const strToArray = str.split('')
    for(let i = 0;i < (strToArray.length/2); i++){
        let temp = strToArray[i]
        let temp2 = strToArray[strToArray.length-i-1] 
        strToArray[i] = temp2
        strToArray[strToArray.length-i-1] = temp;
    }
    return strToArray.join("")

};

function sol02(str) {
    return str.split('').reverse().join('')
};

const sol03 = str => str.split('').reverse().join('')

const sol04  = (str) => {
    if(str == ""){
        return "";
    }else{
        return sol04(str.substring(1)) + str.charAt(0)
    }
}

console.log(sol01(str));
console.log(sol02(str));
console.log(sol03(str));
console.log(sol04(str));