struct data
{
    v: i32,
    to_add: bool
}

fn main() {

let d1 = data {v: 8, to_add: true};
let d2 = data { v: 25, to_add : false};

let mut c = vec![d1, d2];
let c[1].v = 6;

print !(c[1].v);

}



