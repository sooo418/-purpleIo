const foo = (ids) => {
    ids.sort( function(a, b) {
        return a - b;
    } );
    var old = ids[0];
    for(const value of ids) {
        if ( old != value && old + 1 != value ) {
            return old + 1;
        }
        old = value;
    }
    return parseInt( ids.slice(-1) ) + 1;
}