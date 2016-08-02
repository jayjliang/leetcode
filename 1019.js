var readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.on('line', function(line){
    cal(parseInt(line));
});

function format(number) {
    if(number<10) {
        return "000" + number.toString();
    } 
    else if(number<100) {
        return "00" + number.toString();
    }
    else if(number<1000) {
        return "0" + number.toString();
    } else {
        return number;
    }
}

function cal(number) {
    var bit = [];
    while(number>0) {
        bit.push(number%10);
        number = parseInt(number/10);
    }
    var left = 4-bit.length;
    if(left>0){
        for(var i =0;i<left;i++) {
            bit.push(0);
        }
    }
    // console.log(bit);
    bit.sort();
    var second = parseInt(bit.join(""));
    var first = parseInt(bit.reverse().join(""));
    var sub = first-second;
    // console.log(first,second,sub);
    if(sub===0) {
        console.log(format(first)+" - "+format(second)+" = 0000");
        return;
    } else if(sub===6174) {
        console.log(format(first)+" - "+format(second)+" = 6174");
        return;
    } else {
        console.log(format(first)+" - "+format(second)+" = "+format(sub));
        cal(sub);
    }
}