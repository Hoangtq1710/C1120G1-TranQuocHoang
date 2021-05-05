console.log("\nFUNCTION 1");
(function main() {
    console.log("START");
    let target;
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

    let y = 55;
    console.log(y);
    y = 100;
    console.log(y);
})();

console.log("\nFUNCTION 3");
(function main() {
    var x = 5;
    console.log(x);

    let y = 10;
    console.log(y);

})();

console.log("\nFUNCTION 4");
(function main() {
    let message: string;
    let total: number = 100;
    let isProduction = true;
    let prices: Array<number> = [125, 88, 60];
    let languages: string[] = ['vi', 'en-us'];
    let now = new Date();
    let unknown: any;

    let map = prices.map(x => console.log(x));
    let myFilter = languages.filter(x => function () {
        if (x.length == 2) {
            console.log(x);
        }
    })

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    };

    function log(msg: string): void {
        console.log(msg)
    }

    interface IPost {
        id: string;
        title: string;
        body?: string;
    }

    isProduction = false;
    console.log(Direction.UP);
    unknown = 'changed';

    const post: IPost = {
        id: "", title: ""

    };
    message = "50";

    function getPost(postId: string): IPost {
        // do something to retrieve post
        return {
            id: postId,
            title: 'Post Title',
            body: 'Post Body',
            extra: 'data'
        } as IPost;
    }
})();

