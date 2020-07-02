process.stdin.resume();
process.stdin.setEncoding('utf-8');

let currentLine = 0
let stdInput = ''

process.stdin.on('data', raw => {
    stdInput += raw
})

process.stdin.on('end', _ => {
    stdInput = stdInput.trim().split('\n').map(line => {
        return line.trim();
    })

    main()
})

function readLine() {
    return stdInput[currentLine++]
}

function main() {
    const range = +(readLine())
    for(let i = 0; i <= range; i++){
        console.log(i)
    }
}