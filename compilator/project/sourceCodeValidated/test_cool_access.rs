struct vecteur
{
    x: i32,
    y: i32
}

struct data
{
    v: vecteur,
    to_add: bool
}

struct data2
{
  d: data
}

fn main(){
    let x= data{v:vecteur{x:10, y:10}, to_add:false};
    let x.to_add = true;
    let x.v = vecteur{x:10, y:20};
    let d2 = data2{d:x};
    let d2.d.v.x = d2.d.v.y;
}