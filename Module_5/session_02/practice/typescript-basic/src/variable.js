console.log("\nFUNCTION 1");
(function main() {
    console.log("START");
    var target;
    if (true) {
        var lang = "vi";
        target = "en-us";
        console.log("inside block");
        console.log(target);
    }
    console.log(lang);
    console.log(target);
})();
console.log("\nFUNCTION 2");
(function main() {
    var x = 5;
    console.log(x);
    x = 10;
    console.log(x);
    var y = 55;
    console.log(y);
    y = 100;
    console.log(y);
})();
console.log("\nFUNCTION 3");
(function main() {
    var x = 5;
    console.log(x);
    var y = 10;
    console.log(y);
})();
console.log("\nFUNCTION 4");
(function main() {
    var message;
    var total = 100;
    var isProduction = true;
    var prices = [120, 88, 60];
    var languages = ['vi', 'en-us'];
    var now = new Date();
    var unknown;
    var map = prices.map(function (x) { return console.log(x); });
    var myFilter = languages.filter(function (x) { return function () {
        if (x.length == 2) {
            console.log(x);
        }
    }; });
    var Direction;
    (function (Direction) {
        Direction[Direction["UP"] = 0] = "UP";
        Direction[Direction["DOWN"] = 1] = "DOWN";
        Direction[Direction["LEFT"] = 2] = "LEFT";
        Direction[Direction["RIGHT"] = 3] = "RIGHT";
    })(Direction || (Direction = {}));
    ;
    function log(msg) {
        console.log(msg);
    }
    isProduction = false;
    console.log(Direction.UP);
    unknown = 'changed';
    var post = {
        id: "", title: ""
    };
    message = "50";
    function getPost(postId) {
        // do something to retrieve post
        return {
            id: postId,
            title: 'Post Title',
            body: 'Post Body',
            extra: 'data'
        };
    }
})();
