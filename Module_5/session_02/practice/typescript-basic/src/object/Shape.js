"use strict";
exports.__esModule = true;
exports.Shapes = void 0;
var Shapes = /** @class */ (function () {
    function Shapes(x, y) {
        this._x = x;
        this._y = y;
    }
    Object.defineProperty(Shapes.prototype, "x", {
        get: function () {
            return this._x;
        },
        set: function (value) {
            this._x = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Shapes.prototype, "y", {
        get: function () {
            return this._y;
        },
        set: function (value) {
            this._y = value;
        },
        enumerable: false,
        configurable: true
    });
    return Shapes;
}());
exports.Shapes = Shapes;
