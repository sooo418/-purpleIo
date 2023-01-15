const foo = (games) => {
    var result = 0;
    for(var game of games) {
        myScore = parseInt(game.split(":")[0]);
        otherScore = parseInt(game.split(":")[1]);
        result += myScore >= otherScore ? (myScore > otherScore ? 3 : 1) : 0;
    }
    return result;
}