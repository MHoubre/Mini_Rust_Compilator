struct point {
    x:i32,
    y: i32
}

struct vecteur
{
    p: point,
    z: i32
}

struct data
{
    v: vecteur,
    to_add: bool
}

fn printcoords(d : data){
    print!(d.v.z);
}

fn main(){
    let d1 = data {v: vecteur{p: point{x:12,y:13}, z:6}, to_add: true};
    printcoords(d1);
}