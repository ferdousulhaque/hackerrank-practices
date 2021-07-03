'use strict';


/*
* The function is expected to return an Integer
* 1. STRING_ARRAY codeList
* 2. STRING_ARRAY shoppingCart
*/

const unique = (value, index, self) => {
  return self.indexOf(value) === index
}

// Hackerrank Amazon Interview Test #02
function promo(codeList, shoppingCart){
    // get unique combinations from an array
    let concatList = [];
    codeList.forEach(arr => arr.forEach(x => concatList.push(x))); // O(a*b)

    let combinations = shoppingCart.filter(unique).map(x => concatList.toString().replace('anything',x)); // O(n)

    let finder = 'No';
    
    combinations.forEach( each => {
        if(shoppingCart.toString().match(each) != null){
            finder = 'Yes';
        };
    }); // O(n)
    
    return finder;
}

function main(){
    let codeList = [
        ['apple', 'apple'],
        ['banana', 'anything', 'banana']
    ];
    let shoppingCart = ['orange', 'apple', 'apple', 'banana', 'kiwi', 'banana'];
    // promo(codeList, shoppingCart);
    console.log(promo(codeList, shoppingCart));
}

main(); // O(a*b)