const foo = (nums) => {
    var copyIn = [...nums].sort();
    return nums.indexOf(copyIn[1]);
}