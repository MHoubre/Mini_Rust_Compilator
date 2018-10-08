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

fn main(){
  let v = vecteur{x:10, y:10};
  let d = data{v:v, to_add: false};
  let d.v.x = d.v.y  ;
}
