/** layui-v2.0.2 MIT License By http://www.layui.com */
;layui.define("layer", function (e) {
    "use strict";
    var i = layui.$, t = layui.layer, n = (layui.hint(), layui.device()), o = {
            config: {}, set: function (e) {
                var t = this;
                return t.config = i.extend({}, t.config, e), t
            }, on: function (e, i) {
                return layui.onevent.call(this, l, e, i)
            }
        }, a = function () {
            var e = this;
            return {
                upload: function (i) {
                    e.upload.call(e, i)
                }, config: e.config
            }
        }, l = "upload", r = "layui-upload-file", u = "layui-upload-form", c = "layui-upload-iframe",
        s = "layui-upload-choose", f = function (e) {
            var t = this;
            t.config = i.extend({}, t.config, o.config, e), t.render()
        };
    f.prototype.config = {
        accept: "images",
        exts: "",
        auto: !0,
        bindAction: "",
        url: "",
        field: "file",
        method: "post",
        data: {},
        drag: !0,
        size: 0,
        multiple: !1
    }, f.prototype.render = function (e) {
        var t = this, e = t.config;
        e.elem = i(e.elem), e.bindAction = i(e.bindAction), t.file(), t.events()
    }, f.prototype.file = function () {
        var e = this, t = e.config,
            o = e.elemFile = i(['<input class="' + r + '" type="file" name="' + t.field + '"', t.multiple ? " multiple" : "", ">"].join("")),
            a = t.elem.next();
        (a.hasClass(r) || a.hasClass(u)) && a.remove(), n.ie && n.ie < 10 && t.elem.wrap('<div class="layui-upload-wrap"></div>'), e.isFile() ? (e.elemFile = t.elem, t.field = t.elem[0].name) : t.elem.after(o), n.ie && n.ie < 10 && e.initIE()
    }, f.prototype.initIE = function () {
        var e = this, t = e.config,
            n = i('<iframe id="' + c + '" class="' + c + '" name="' + c + '" frameborder="0"></iframe>'),
            o = i(['<form target="' + c + '" class="' + u + '" method="' + t.method, '" key="set-mine" enctype="multipart/form-data" action="' + t.url + '">', "</form>"].join(""));
        i("#" + c)[0] || i("body").append(n), t.elem.next().hasClass(c) || (e.elemFile.wrap(o), t.elem.next("." + c).append(function () {
            var e = [];
            return layui.each(t.data, function (i, t) {
                e.push('<input type="hidden" name="' + i + '" value="' + t + '">')
            }), e.join("")
        }()))
    }, f.prototype.msg = function (e) {
        return t.msg(e, {icon: 2, shift: 6})
    }, f.prototype.isFile = function () {
        var e = this.config.elem[0];
        if (e) return "input" === e.tagName.toLocaleLowerCase() && "file" === e.type
    }, f.prototype.preview = function (e) {
        var i = this;
        window.FileReader && layui.each(i.chooseFiles, function (i, t) {
            var n = new FileReader;
            n.readAsDataURL(t), n.onload = function () {
                e && e(i, t, this.result)
            }
        })
    }, f.prototype.upload = function (e, t) {
        var o, a = this, l = a.config, r = a.elemFile[0], u = function () {
            layui.each(e || a.files || a.chooseFiles || r.files, function (e, t) {
                var n = new FormData;
                n.append(l.field, t), layui.each(l.data, function (e, i) {
                    n.append(e, i)
                }), i.ajax({
                    url: l.url,
                    type: l.method,
                    data: n,
                    contentType: !1,
                    processData: !1,
                    dataType: "json",
                    success: function (i) {
                        d(e, i)
                    },
                    error: function () {
                        a.msg("??????????????????????????????"), m(e)
                    }
                })
            })
        }, p = function () {
            var e = i("#" + c);
            a.elemFile.parent().submit(), clearInterval(f.timer), f.timer = setInterval(function () {
                var i, t = e.contents().find("body");
                try {
                    i = t.text()
                } catch (n) {
                    a.msg("??????????????????????????????????????????"), clearInterval(f.timer), m()
                }
                i && (clearInterval(f.timer), t.html(""), d(0, i))
            }, 30)
        }, d = function (e, i) {
            if (a.elemFile.next("." + s).remove(), r.value = "", "object" != typeof i) try {
                i = JSON.parse(i)
            } catch (t) {
                return i = {}, a.msg("??????????????????????????????JSON")
            }
            "function" == typeof l.done && l.done(i, e || 0, function (e) {
                a.upload(e)
            })
        }, m = function (e) {
            l.auto && (r.value = ""), "function" == typeof l.error && l.error(e || 0, function (e) {
                a.upload(e)
            })
        }, v = l.exts, h = function () {
            var i = [];
            return layui.each(e || a.chooseFiles, function (e, t) {
                i.push(t.name)
            }), i
        }(), g = {
            preview: function (e) {
                a.preview(e)
            }, upload: function (e, i) {
                var t = {};
                t[e] = i, a.upload(t)
            }, pushFile: function () {
                return a.files = a.files || {}, layui.each(a.chooseFiles, function (e, i) {
                    a.files[e] = i
                }), a.files
            }, elemFile: r
        }, y = function () {
            return "choose" === t ? l.choose && l.choose(g) : (l.before && l.before(g), n.ie ? n.ie > 9 ? u() : p() : void u())
        };
        switch (h = 0 === h.length ? r.value.match(/[^\/\\]+\..+/g) || [] || "" : h, l.accept) {
            case"file":
                if (v && !RegExp("\\w\\.(" + v + ")$", "i").test(escape(h))) return a.msg("??????????????????????????????????????????"), r.value = "";
                break;
            case"video":
                if (!RegExp("\\w\\.(" + (v || "avi|mp4|wma|rmvb|rm|flash|3gp|flv") + ")$", "i").test(escape(h))) return a.msg("??????????????????????????????????????????"), r.value = "";
                break;
            case"audio":
                if (!RegExp("\\w\\.(" + (v || "mp3|wav|mid") + ")$", "i").test(escape(h))) return a.msg("??????????????????????????????????????????"), r.value = "";
                break;
            default:
                if (layui.each(h, function (e, i) {
                    RegExp("\\w\\.(" + (v || "jpg|png|gif|bmp|jpeg$") + ")", "i").test(escape(i)) || (o = !0)
                }), o) return a.msg("??????????????????????????????????????????"), r.value = ""
        }
        return l.size > 0 && !(n.ie && n.ie < 10) ? layui.each(a.chooseFiles, function (e, i) {
            if (i.size > 1024 * l.size) {
                var t = l.size / 1024;
                return t = t >= 1 ? Math.floor(t) + (t % 1 > 0 ? t.toFixed(1) : 0) + "MB" : l.size + "KB", r.value = "", a.msg("??????????????????" + t)
            }
            y()
        }) : void y()
    }, f.prototype.events = function () {
        var e = this, t = e.config, o = function (i) {
            e.chooseFiles = {}, layui.each(i, function (i, t) {
                var n = (new Date).getTime();
                e.chooseFiles[n + "-" + i] = t
            })
        }, a = function (i, n) {
            var o = e.elemFile,
                a = i.length > 1 ? i.length + "?????????" : (i[0] || {}).name || o[0].value.match(/[^\/\\]+\..+/g) || [] || "";
            o.next().hasClass(s) && o.next().remove(), e.upload(null, "choose"), e.isFile() || t.choose || o.after('<span class="layui-inline ' + s + '">' + a + "</span>")
        };
        t.elem.off("upload.start").on("upload.start", function () {
            e.elemFile[0].click()
        }), n.ie && n.ie < 10 || t.elem.off("upload.over").on("upload.over", function () {
            var e = i(this);
            e.attr("lay-over", "")
        }).off("upload.leave").on("upload.leave", function () {
            var e = i(this);
            e.removeAttr("lay-over")
        }).off("upload.drop").on("upload.drop", function (n, l) {
            var r = i(this), u = l.originalEvent.dataTransfer.files || [];
            r.removeAttr("lay-over"), o(u), t.auto ? e.upload(u) : a(u)
        }), e.elemFile.off("upload.change").on("upload.change", function () {
            var i = this.files || [];
            o(i), t.auto ? e.upload() : a(i)
        }), t.bindAction.off("upload.action").on("upload.action", function () {
            e.upload()
        }), t.elem.data("haveEvents") || (e.elemFile.on("change", function () {
            i(this).trigger("upload.change")
        }), t.elem.on("click", function () {
            e.isFile() || i(this).trigger("upload.start")
        }), t.drag && t.elem.on("dragover", function (e) {
            e.preventDefault(), i(this).trigger("upload.over")
        }).on("dragleave", function (e) {
            i(this).trigger("upload.leave")
        }).on("drop", function (e) {
            e.preventDefault(), i(this).trigger("upload.drop", e)
        }), t.bindAction.on("click", function () {
            i(this).trigger("upload.action")
        }), t.elem.data("haveEvents", !0))
    }, o.render = function (e) {
        var i = new f(e);
        return a.call(i)
    }, e(l, o)
});