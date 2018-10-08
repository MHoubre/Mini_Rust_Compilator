struct str_rec_id
{
	is_set : bool,
	address_anchor : &i32
}
struct str_rec
{
	cnst : i32,
	rec : &vec<str_rec>,
	id : str_rec_id
}
fn looping_binding(addr_str_rec : &str_rec, counter: i32)
{
	let (*str_rec).rec = &(vec![*str_rec]);
	let mut i = 0;
	let current = (*((*str_rec).rec))[0];
	while i < counter
	{
		let current.cnst = current.cnst/2 + *((*((*current).rec)[0]).id.address_anchor);
		let current = (*((*current).rec))[0];
		let i = i +1;
	}
}
fn main()
{
	let anchor = 9*(8/(7+6)/(5/4+3-2)+1)+11;
	let top_layer_id = str_rec_id{is_set : true,address_anchor : &anchor};
	let mut str_target= str_rec{cnst : 0, rec : -1, id : top_layer_id};
	looping_binding(&str_target, 3);
	print!(str_target.cnst);
}