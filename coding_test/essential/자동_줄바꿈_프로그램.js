const foo = (str) => {
    var result = "";
    var start = 0;
    var cnt = 0;
    const korean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

    for(var i = 0; i < str.length; i++) {
        if ( korean.test(str[i]) ) {
            cnt += 2;
        } else {
            cnt++;
        }

        if ( cnt == 79 && korean.test(str[i + 1]) ) {
            result += str.substring(start, i + 1) + "\n";
            start = i + 1;
            cnt = 0;
        }
        else if ( cnt >= 80 ) {
            if ( str[i + 1] == " " ) {
                result += str.substring(start, ++i) + "\n";
            } else {
                result += str.substring(start, i + 1) + "\n";
            }
            start = i + 1;
            cnt = 0;
        }
    }
    result += str.substring(start);
    return result;
}