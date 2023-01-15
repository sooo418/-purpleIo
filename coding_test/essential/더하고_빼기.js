var fruit = {	// 9의 배수들만 값이 apple이므로 9 -> 1, 18 -> 2 ... 99 -> 11 로 변경
    1:"apple",
    2:"apple",
    3:"apple",
    4:"apple",
    5:"apple",
    6:"apple",
    7:"apple",
    8:"apple",
    9:"apple",
    // 10:"apple", 즉, 90이란 값은 나올 수가 없음
    11:"apple"
};

// case1
const foo1 = (n) => {
    return n >= 100 ? fruit[11] : fruit[parseInt(n / 10)];
}

// case2
const foo2 = (n) => {
    var result = 0;
    var sub = 0;
    for(var num of String(n)) {
        sub += parseInt(num);
    }
    result = n - sub;
    return result > 100 ? foo2(result) : fruit[result / 9];
}