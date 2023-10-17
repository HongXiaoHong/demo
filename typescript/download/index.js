function downloadFile(url, filename) {
    fetch(url, {
        headers: new Headers({
            Origin: location.origin,
        }),
        mode: 'cors',
    })
        .then(function (res) {
        if (res.status == 200) {
            // 返回的.blob()为promise，然后生成了blob对象，此方法获得的blob对象包含了数据类型，十分方便
            return res.blob();
        }
        throw new Error("status: ".concat(res.status, "."));
    })
        .then(function (blob) {
        download(blob, filename);
    });
}
function download(blob, filename) {
    var a = document.createElement('a');
    a.download = filename;
    var blobUrl = URL.createObjectURL(blob);
    a.href = blobUrl;
    document.body.appendChild(a);
    a.click();
    a.remove();
    URL.revokeObjectURL(blobUrl);
}
