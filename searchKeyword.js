'use strict';


// Hackerrank Amazon Interview Test #01
function search(itemList, searchWord){
    let sortedList = itemList.map(x => x.toLowerCase()).sort();
    let result = [];
    
    for(let i = 1; i < searchWord.length+1; i++){
        result.push(sortedList.filter(
                x => x.match(`${searchWord.substring(0,i)}`)
            )
        );
    }
    return result;
}

function main(){
    let itemList = ['ball','box', 'bAgs', 'ballon', 'banana'];
    let searchWord = 'ball';
    let result = search(itemList, searchWord);
    console.log(result);
}

main();