import { NextResponse } from "next/server";

export default function middleware(req)

{

  let verify = req.cookies.get("loggedin");

  let url = req.url

  if(!verify && url.includes('/welcome'))
    {

    return NextResponse.redirect("http://localhost:3000/");

    }

  if(verify && url=== "http://localhost:3000/")
    {

    return NextResponse.redirect("http://localhost:3000/welcome");

  }

}


//amoxicillin 500mg        ibuproten 400mg tab