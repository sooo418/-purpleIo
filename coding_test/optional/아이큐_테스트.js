const foo = (numbers) => {
    var list = numbers.split(" ");
    var filterList = [];
    return list.indexOf( (filterList = list.filter (num => num % 2)). length == 1 ? filterList[0] : list.find(num => ! (num % 2)) ) + 1;
}