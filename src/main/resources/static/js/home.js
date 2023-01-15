function enter(e) {
    if ( e.keyCode == 13 ) {
        requestUrl();
    }
}

function drawEmbedInf(embed) {
    let data = "";

    if(embed.type != null)
        data += "<li>" + "<div>type</div><div>" + embed.type + "</div></li>";
    if(embed.version != null)
        data += "<li>" + "<div>version</div><div>" + embed.version + "</div></li>";
    if(embed.provider_name != null)
        data += "<li>" + "<div>provider_name</div><div>" + embed.provider_name + "</div></li>";
    if(embed.provider_url != null)
        data += "<li>" + "<div>provider_url</div><div><a href='"+ embed.provider_url + "'>"
            + embed.provider_url + "</a></div></li>";
    if(embed.author_name != null)
        data += "<li>" + "<div>author_name</div><div>" + embed.author_name + "</div></li>";
    if(embed.author_url != null)
        data += "<li>" + "<div>author_url</div><div><a href='"+ embed.author_url + "'>"
            + embed.author_url + "</a></div></li>";
    if(embed.is_plus != null)
        data += "<li>" + "<div>is_plus</div><div>" + embed.is_plus + "</div></li>";
    if(embed.html != null)
        data += "<li>" + "<div>html<br/>(" + embed.width + "/" + embed.height + ")</div><div><xmp>"
            + embed.html + "</xmp>"+ embed.html + "</div></li>";
    if(embed.width != null)
        data += "<li>" + "<div>width</div><div>" + embed.width + "</div></li>";
    if(embed.height != null)
        data += "<li>" + "<div>height</div><div>" + embed.height + "</div></li>";
    if(embed.duration != null)
        data += "<li>" + "<div>height</div><div>" + embed.duration + "</div></li>";
    if(embed.description != null)
        data += "<li>" + "<div>height</div><div>" + embed.description + "</div></li>";
    if(embed.thumbnail_url != null)
        data += "<li>" + "<div>thumbnail_url<br/>(" + embed.thumbnail_width + "/" + embed.thumbnail_height + ")</div><div><a href='"
            +embed.thumbnail_url+"'>" + embed.thumbnail_url + "</a><br/><br/><img src='"+embed.thumbnail_url+"'/></div></li>";
    if(embed.thumbnail_width != null)
        data += "<li>" + "<div>thumbnail_width</div><div>" + embed.thumbnail_width + "</div></li>";
    if(embed.thumbnail_height != null)
        data += "<li>" + "<div>thumbnail_height</div><div>" + embed.thumbnail_height + "</div></li>";
    if(embed.thumbnail_url_with_play_button != null)
        data += "<li>" + "<div>thumbnail_url_with_play_button</div><div><a href='"+ embed.thumbnail_url_with_play_button
            + "'>" + embed.thumbnail_url_with_play_button + "</a></div></li>";
    if(embed.upload_data != null)
        data += "<li>" + "<div>upload_data</div><div>" + embed.upload_data + "</div></li>";
    if(embed.video_id != null)
        data += "<li>" + "<div>video_id</div><div>" + embed.video_id + "</div></li>";
    if(embed.uri != null)
        data += "<li>" + "<div>uri</div><div>" + embed.uri + "</div></li>";
    if(embed.cache_age != null)
        data += "<li>" + "<div>cache_age</div><div>" + embed.cache_age + "</div></li>";
    return data;
}

function requestUrl() {
    const userUrlData = document.getElementById('url').value;
    //oembedResponse에서 데이터 response

    fetch('search?url='+userUrlData)
        .then((result) => {
            result.json()
                .then((json) =>{
                    // 에러 메시지
                    if(json.status != '200') {
                        if(json.status == '500') {
                            alert('서버에 장애가 발생하였습니다. 문의바랍니다. \r' + json.status + ' - ' + json.msg);
                            return;
                        }
                        alert('유요하지 않은 주소입니다. \r' + json.status + ' - ' + json.msg);
                        return;
                    }
                    console.log(json);

                    const render = document.getElementById('data_in_container');
                    const render2 = document.getElementById('title_container');

                    //API 호출시 화면 초기화
                    render.innerHTML = "";
                    render2.innerHTML = "";

                    let embed = json.embed;

                    let title = "";
                    if(embed.title != null){
                        title = "<div><div>title</div><div>" + embed.title + "</div></div>";
                        render2.innerHTML = title;
                    }

                    let data = drawEmbedInf(embed);
                    render.innerHTML = data;
                }).catch((err)=>{
                alert('유요하지 않은 주소입니다.');
                console.log(err);
            })
        })
        .catch((err) => {
            alert('유요하지 않은 주소입니다.');
            console.log(err);
        });

}