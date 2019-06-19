
/**
 * async和await的实现原理
 * 实际上就是generator的语法糖
 * 我们的await需要的是一个promise对象
 * 这样每次yield的时候就会去在promise的then回调里面去执行下次next
 * @param {*} a 
 */

function readFile(a) {
    return new Promise(resolve => {
        setTimeout(() => {
            console.log(a);
            resolve(a);
        }, 5000)
    })
}
function* foo() {
    console.log('a')
    var result = yield readFile('b');
    console.log('c');
    yield readFile('d');
    console.log('e');
}
function run(g) {
    var res = g.next(); //记住res.value是个promise对象
    if (!res.done) {
        res.value.then(() => {   //promise解决了才继续执行生成器内部函数
            run(g);
        })
    }
}
run(foo());

