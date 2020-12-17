
// let email = prompt("Email:");
// let op = checking_email_format(email);

function checking_email_format(checkingEmail) {
    let count_dot = 0;
    let count_at = 0;
    let flag = true;
    // let allowed =   [0,1,2,3,4,5,6,7,8,9,
    //                 ".","@",
    //                 "q","w","e","r","t","y","u","i","o","p",
    //                 "a","s","d","f","g","h","j","k","l",
    //                 "z","x","c","v","b","n","m"
    //                 ];
    // let count_allow = 0;
    let special_characters =   ["“","‘","&","<",">","Œ","œ","Š","š","Ÿ","ƒ","ˆ","˜","&ensp;","&emsp;",
                    "&thinsp;","&zwnj;","&zwj;","&lrm;","&rlm;","–","_","‘","’","‚","“","”","„","†",
                    "‡","•","…","‰","′","″","‹","›","‾",'€',"™","←","↑","→","↓","↔","↵","⌈","⌉","⌊",
                    "⌋","◊","♠","♣","♥","♦","∀","∂","∃","∅","∇","∈","∉","∋","∏","∑","−","∗","√",
                    "∝","∞","∠","∧","∨","∩","∪","∫","∴","∼","≅","≈","≠","≡","≤","≥","⊂","⊃","⊄","⊆",
                    "⊇","⊕","⊗","⊥","⋅","Α","Β","Γ","Δ","Ε","Ζ","Η","Θ","Ι","Κ","Λ","Μ","Ν","Ξ","Ο",
                    "Π","Ρ","Σ","Τ","Υ","Φ","Χ","Ψ","Ω","α","β","γ","δ","ε","ζ","η","θ","ι","κ","λ",
                    "μ","ν","ξ","ο","π","ρ","ς","σ","τ","υ","φ","χ","ψ","ω","ϑ","ϒ","ϖ","À","Á","Â",
                    "Ã","Ä","Å","Æ","Ç","È","É","Ê","Ë","Ì","Í","Î","Ï","Ð","Ñ","Ò","Ó","Ô","Õ","Ö",
                    "Ø","Ù","Ú","Û","Ü","Ý","Þ","ß","à","á","â","ã","ä","å","æ","ç","è","é","ê","ë","ì",
                    "í","î","ï","ð","ñ","ò","ó","ô","õ","ö","ø","ù","ú","û","ü","ý","þ","ÿ","&nbsp;","¡",
                    "¢","£","¤","¥","¦","§","¨","©","ª","«","¬","&shy;","®","¯","°","±","²","³","´","µ",
                    "¶","·","¸","¹","º","»","¼","½","¾","¿","×","÷"
                    ];

    for (let i = 0; i < checkingEmail.length; i++) {
        // kiểm tra nếu 1 kí tự trong chuỗi là @
        if (checkingEmail[i] ==="@") {
            count_at++;
            let dot_after_at = 0;
            for (let j = i + 1; j < checkingEmail.length - 1; j++) {
                if (checkingEmail[j] === ".") {
                    dot_after_at++;
                }
            }
            if (dot_after_at !== 1) {
                flag = false;
            }
            if (checkingEmail[i-1] === ".") {
                flag = false;
            }
        }
        //kiểm tra nếu kí tự trong chuỗi là dấu .
        if (checkingEmail[i] === ".") {
            count_dot++;
            if (i === 0 || i === checkingEmail.length - 1) {
                flag = false;
            } else if (checkingEmail[i+1] === ".") {
                flag = false;
            }
        }
        //kiểm tra nếu kí tự trong chuỗi là space
        if (checkingEmail[i] === " ") {
            flag = false;
        }
        //kiểm tra nếu có kí tự đặc biệt trong chuỗi thì sai
        for (let j = 0; j < special_characters.length; j++) {
            if (checkingEmail[i] === special_characters[j]) {
                flag = false;
            }
        }

        // for (let j = 0; j < allowed.length; j++) {
        //     if (checkingEmail[i] === allowed[j]) {
        //         count_allow++;
        //     }
        // }
        // if (count_allow !== checkingEmail.length) {
        //     flag = false;
        // }

    }
    //chỉ được phép có 1 dấu @
    if (count_at !== 1) {
        flag = false;
    }
    //nếu trong chuỗi, k có dấu chấm nào
    if (count_dot < 1) {
        flag = false;
    }

    if (flag === true) {
        return true;
    }
    return false;
}
