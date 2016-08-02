var readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.on('line', function(line){
    var token = line.split(" ");
    cal(parseInt(token[0]),parseInt(token[1]),parseInt(token[2]),parseInt(token[3]));
});

function getBit(number, filter) {
    var result = [];
    while(number>0) {
        result.push(number%10);
        number = parseInt(number/10);
    }
    var a = result.filter(function(item) {
        return item==filter;
    });
    if(a.length==0) {
        a=[0];
    }
    return a;
}

function cal(A,DA,B,DB) {
    console.log(parseInt(getBit(A,DA).join(""))+parseInt(getBit(B,DB).join("")));
}