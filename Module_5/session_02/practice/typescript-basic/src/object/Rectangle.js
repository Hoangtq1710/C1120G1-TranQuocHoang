"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.Rectangle = void 0;
var Shape_1 = require("./Shape");
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    function Rectangle(x, y, color) {
        var _this = _super.call(this, x, y) || this;
        _this._color = color;
        return _this;
    }
    Object.defineProperty(Rectangle.prototype, "color", {
        get: function () {
            return this._color;
        },
        set: function (value) {
            this._color = value;
        },
        enumerable: false,
        configurable: true
    });
    Rectangle.prototype.getArea = function () {
        return this.x * this.y;
    };
    Rectangle.prototype.showInfor = function () {
        return "Rectangle has width = " + this.x + ", height = " + this.y + ", color is " + this.color + ". Area is " + this.getArea();
    };
    return Rectangle;
}(Shape_1.Shapes));
exports.Rectangle = Rectangle;
