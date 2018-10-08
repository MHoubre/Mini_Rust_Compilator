struct vecteur
{
    x: i32,
    y: i32
}


fn main(){
  let x = 32;
  let y = 10;
  let v = vecteur{x:10, y:10};
  let v2 = vecteur{x:x, y:y};
  let v_notWorking = vecteur{x : 10};
  let v_notWorking2 = vecteur{x : false, y:10};
}
