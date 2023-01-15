const foo = (str) => {
    var vowels = str.match(/[aeiou]/gi);
    return vowels != null ? vowels.length : 0;
}