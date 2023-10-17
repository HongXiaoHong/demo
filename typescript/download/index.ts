function downloadFile(url: string, filename?: string) {
    fetch(url, {
        headers: new Headers({
            Origin: location.origin,
        }),
        mode: 'cors',
    })
        .then(res => {
            if (res.status == 200) {
                // 返回的.blob()为promise，然后生成了blob对象，此方法获得的blob对象包含了数据类型，十分方便
                return res.blob()
            }

            throw new Error(`status: ${res.status}.`)

        })
        .then(blob => {
            download(blob, filename)
        })
}


function download(blob: Blob, filename?: string) {
    const a: any = document.createElement('a')
    a.download = filename
    const blobUrl = URL.createObjectURL(blob)
    a.href = blobUrl
    document.body.appendChild(a)
    a.click()
    a.remove()
    URL.revokeObjectURL(blobUrl)
}
