ES6模块化之export和import的用法
==

## require
```text
require是CommonJS的语法，CommonJS的模块是对象，输入时必须查找对象属性
```
```js
// CommonJS模块
let { stat, exists, readFile } = require('fs');

// 等同于
let _fs = require('fs');
let stat = _fs.stat;
let exists = _fs.exists;
let readfile = _fs.readfile;
```
分析
```text
整体加载fs模块（即加载fs所有方法），生成一个对象"_fs"，
然后再从这个对象上读取三个方法，这叫“运行时加载”，
因为只有运行时才能得到这个对象，不能在编译时做到静态化。
```

## ES6中export两种用法
* 命名导出（Named exports）
* 默认导出（Default exports）

### 命名导出（Named exports）
就是每一个需要导出的数据类型都要有一个name，统一引入一定要带有{}，
即便只有一个需要导出的数据类型。这种写法清爽直观，是推荐的写法。

#### 导出模块
```js
//------ lib.js ------
const sqrt = Math.sqrt;
function square(x) {
    return x * x;
}
function diag(x, y) {
    return sqrt(square(x) + square(y));
}

export {sqrt, square, diag}
```

导入模块
```js
//------ main.js ------
import { square, diag } from 'lib';				
console.log(square(11)); // 121
console.log(diag(4, 3)); // 5
```

#### 把export直接加到声明前面就可以省略{}
```js
//------ lib.js ------
export const sqrt = Math.sqrt;
export function square(x) {
    return x * x;
}
export function diag(x, y) {
    return sqrt(square(x) + square(y));
}
```
```js

//------ main.js ------
import { square, diag } from 'lib';				
console.log(square(11)); // 121
console.log(diag(4, 3)); // 5
```


**复制代码无论怎样导出，引入的时候都需要{}**


#### 别名引入（Aliasing named imports）
当从不同模块引入的变量名相同的时候
```js
import {speak} from './cow.js'
import {speak} from './goat.js'	
```
复制代码这些写法显然会造成混乱  
正确的方法是这样的
```js
import {speak as cowSpeak} from './cow.js'
import {speak as goatSpeak} from './goat.js'
```
复制代码可是，当从每个模块需要引入的方法很多的时候，这种写法就显得十分的繁琐、冗长，例如
```js
import {
  speak as cowSpeak,
  eat as cowEat,
  drink as cowDrink
} from './cow.js'

import {
  speak as goatSpeak,
  eat as goatEat,
  drink as goatDrink
} from './goat.js'

cowSpeak() // moo
cowEat() // cow eats
goatSpeak() // baa
goatDrink() // goat drinks
```


#### 命名空间引入（Namespace imports）
复制代码解决方案就是命名空间引入了
```js
import * as cow from './cow.js'
import * as goat from './goat.js'

cow.speak() // moo
goat.speak() // baa
```
复制代码十分的简洁优雅

### 默认导出（Default exports）
默认导出就不需要name了，但是一个js文件中只能有一个export default。
```js
//------ myFunc.js ------
export default function () { ... };

//------ main1.js ------
import myFunc from 'myFunc';
myFunc();
```
复制代码其实这种导出方式可以看成是命名到处的变种，只不过把命名写成了default。
虽然export default只能有一个，但也可以导出多个方法。
```js
export default {
  speak () {
    return 'moo'
  },
  eat () {
    return 'cow eats'
  },
  drink () {
    return 'cow drinks'
  }
}
```
复制代码引入与命名空间引入类似
```js
import cow from './default-cow.js'
import goat from './default-goat.js'

cow.speak() // moo
goat.speak() // baa
```

复制代码如果我们在编写模块的时候使用的导出方法不统一，
那么引入的时候就需要考虑不同模块引入的方式。这种麻烦可以通过自引用的方法消除。方法如下
编写两种引入方式通用的模块
```js
import * as myself from './ambidextrous-cow.js' // import this file into itself

// this module's own namespace is its default export
export default myself

export function speak () {
  console.log('moo')
}
```

复制代码这样在引入的时候就不需要考虑引入方式了。
```js
import cow from './ambidextrous-cow'
import * as alsocow from './ambidextrous-cow'

cow.speak() // moo
alsocow.speak() // moo
```

复制代码两种引入方法均可。
这种方法也有一个小缺点，就是在我们编写的模块中，有一个function是常用的，我们想默认导出，可export default已经使用了，而我们知道export default在一个模块中只能使用一次。这时就要使用Object.assign
```js
import * as myself from './ambidextrous-cow.js' 

export default Object.assign(speak, myself) 

export function speak () {
  console.log('moo')
}
```

复制代码需要注意的是，Object.assign只能用于function。
对应引入的例子
```js
import cow from './ambidextrous-cow'
import * as alsocow from './ambidextrous-cow'

cow() // moo
cow.speak() // moo
alsocow.speak() // moo
```
